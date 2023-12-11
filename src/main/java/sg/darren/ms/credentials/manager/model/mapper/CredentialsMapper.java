package sg.darren.ms.credentials.manager.model.mapper;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import sg.darren.ms.credentials.manager.model.dto.CredentialsCreateReqDto;
import sg.darren.ms.credentials.manager.model.dto.CredentialsResDto;
import sg.darren.ms.credentials.manager.model.dto.CredentialsUpdateReqDto;
import sg.darren.ms.credentials.manager.model.entity.CredentialsEntity;

@Component
@RequiredArgsConstructor
public class CredentialsMapper {

    private final ModelMapper modelMapper;

    public CredentialsEntity createDtoToEntity(CredentialsCreateReqDto dto) {
        return CredentialsEntity.builder()
                .appName(dto.getAppName())
                .loginId(dto.getLoginId())
                .password(dto.getPassword())
                .remarks(dto.getRemarks())
                .build();
    }

    public CredentialsEntity updateDtoToEntity(CredentialsUpdateReqDto dto, CredentialsEntity entity) {
        entity.setAppName(dto.getAppName());
        entity.setLoginId(dto.getLoginId());
        entity.setPassword(dto.getPassword());
        entity.setRemarks(dto.getRemarks());
        return entity;
    }

    public CredentialsResDto entityToResDto(CredentialsEntity entity) {
        return modelMapper.map(entity, CredentialsResDto.class);
    }

}
