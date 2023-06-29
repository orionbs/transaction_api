package fr.orionbs.transaction_manager.adapter.input.api.frequency.mapper;

import fr.orionbs.transaction_manager.adapter.input.api.frequency.data.FrequencyException;
import fr.orionbs.transaction_manager.adapter.input.api.frequency.data.FrequencySelectionResponse;
import fr.orionbs.transaction_manager.domain.model.Frequency;
import org.springframework.stereotype.Component;

@Component
public class FrequencyApiMapper {

    public FrequencySelectionResponse toFrequencySelectionResponse(Frequency frequency) {
        FrequencySelectionResponse frequencySelectionResponse = new FrequencySelectionResponse();
        frequencySelectionResponse.setId(frequency.getId());
        frequencySelectionResponse.setValue(frequency.getFrequencyEnum().toString());
        return frequencySelectionResponse;
    }

    public FrequencyException toFrequencyException(Exception exception) {
        FrequencyException frequencyException = new FrequencyException();
        frequencyException.setMessage(exception.getMessage());
        return frequencyException;
    }

}
