package fr.orionbs.transaction_manager.adapter.input.api.frequency;

import fr.orionbs.transaction_manager.adapter.input.api.frequency.data.FrequencyException;
import fr.orionbs.transaction_manager.adapter.input.api.frequency.data.FrequencySelectionResponse;
import fr.orionbs.transaction_manager.adapter.input.api.frequency.mapper.FrequencyApiMapper;
import fr.orionbs.transaction_manager.adapter.input.api.frequency.specification.FrequencyApi;
import fr.orionbs.transaction_manager.application.input.GetFrequencyUseCase;
import fr.orionbs.transaction_manager.domain.exception.UnknownFrequencyException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequiredArgsConstructor
public class FrequencyApiAdapter implements FrequencyApi {

    private final GetFrequencyUseCase getFrequencyUseCase;
    private final FrequencyApiMapper frequencyApiMapper;

    @Override
    public List<FrequencySelectionResponse> getFrequencies() {
        return getFrequencyUseCase
                .getFrequencies()
                .stream()
                .map(frequencyApiMapper::toFrequencySelectionResponse)
                .collect(Collectors.toList());
    }

    @Override
    public FrequencySelectionResponse getFrequencyById(Integer frequencyId) throws UnknownFrequencyException {
        return frequencyApiMapper.toFrequencySelectionResponse(getFrequencyUseCase.getFrequencyById(frequencyId));
    }

    @Override
    public FrequencyException unknownFrequencyException(UnknownFrequencyException unknownFrequencyException) {
        return frequencyApiMapper.toFrequencyException(unknownFrequencyException);
    }

}
