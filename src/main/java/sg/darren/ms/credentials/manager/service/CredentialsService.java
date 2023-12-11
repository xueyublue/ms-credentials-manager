package sg.darren.ms.credentials.manager.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sg.darren.ms.credentials.manager.CredentialsRepository;
import sg.darren.ms.credentials.manager.exception.DataNotFoundException;
import sg.darren.ms.credentials.manager.model.dto.CredentialsCreateReqDto;
import sg.darren.ms.credentials.manager.model.dto.CredentialsResDto;
import sg.darren.ms.credentials.manager.model.dto.CredentialsUpdateReqDto;
import sg.darren.ms.credentials.manager.model.entity.CredentialsEntity;
import sg.darren.ms.credentials.manager.model.mapper.CredentialsMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CredentialsService {

    private final CredentialsRepository credentialsRepository;
    private final CredentialsMapper credentialsMapper;
    private final EncryptDecryptService encryptDecryptService;

    public CredentialsResDto get(Integer id) {
        return credentialsRepository.findById(id)
                .map(credentialsMapper::entityToResDto)
                .orElse(null);
    }

    public List<CredentialsResDto> getList() {
        return credentialsRepository.findAll().stream()
                .map(credentialsMapper::entityToResDto)
                .collect(Collectors.toList());
    }

    public CredentialsResDto create(CredentialsCreateReqDto dto) throws Exception {
        CredentialsEntity entityToSave = credentialsMapper.createDtoToEntity(dto);
        entityToSave.setPassword(encryptDecryptService.encrypt(dto.getPassword()));
        return credentialsMapper.entityToResDto(credentialsRepository.save(entityToSave));
    }

    public CredentialsResDto update(Integer id, CredentialsUpdateReqDto dto) throws Exception {
        Optional<CredentialsEntity> oldEntity = credentialsRepository.findById(id);
        if (oldEntity.isEmpty()) {
            throw DataNotFoundException.credentialsNotFound(id);
        }
        CredentialsEntity entityToUpdate = credentialsMapper.updateDtoToEntity(dto, oldEntity.get());
        entityToUpdate.setPassword(encryptDecryptService.encrypt(dto.getPassword()));
        return credentialsMapper.entityToResDto(credentialsRepository.save(entityToUpdate));
    }

    public void delete(Integer id) {
        if (credentialsRepository.findById(id).isEmpty()) {
            throw DataNotFoundException.credentialsNotFound(id);
        }
        credentialsRepository.deleteById(id);
    }

}
