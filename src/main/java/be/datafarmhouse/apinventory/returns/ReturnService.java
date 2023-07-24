package be.datafarmhouse.apinventory.returns;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReturnService {

    private final ReturnRepository returnRepository;

    public ReturnData createReturn(final ReturnData returnData) {
        return returnRepository.save(returnData);
    }
}
