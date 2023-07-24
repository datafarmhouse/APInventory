package be.datafarmhouse.apinventory.api;

import be.datafarmhouse.apinventory.returns.ReturnData;
import be.datafarmhouse.apinventory.returns.ReturnService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ReturnAPI {

    private final ReturnService returnService;

    @PostMapping("/api/returns")
    public void createReturn(@RequestBody final ReturnData returnData) {
        returnService.createReturn(returnData);
    }
}
