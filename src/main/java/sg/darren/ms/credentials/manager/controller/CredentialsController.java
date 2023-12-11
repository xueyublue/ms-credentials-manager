package sg.darren.ms.credentials.manager.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import sg.darren.ms.credentials.manager.model.dto.CredentialsCreateReqDto;
import sg.darren.ms.credentials.manager.model.dto.CredentialsResDto;
import sg.darren.ms.credentials.manager.model.dto.CredentialsUpdateReqDto;
import sg.darren.ms.credentials.manager.service.CredentialsService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/credentials")
public class CredentialsController {

    private final CredentialsService credentialsService;

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CredentialsResDto get(@PathVariable("id") Integer id) {
        return credentialsService.get(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CredentialsResDto> getList() {
        return credentialsService.getList();
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public CredentialsResDto create(@RequestBody CredentialsCreateReqDto dto) throws Exception {
        return credentialsService.create(dto);
    }

    @PutMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CredentialsResDto update(
            @PathVariable("id") Integer id,
            @RequestBody CredentialsUpdateReqDto dto) throws Exception {
        return credentialsService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Integer id) {
        credentialsService.delete(id);
        return "success";
    }

}
