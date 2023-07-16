package fr.orionbs.transaction_manager_server.adapter.output.persistence.frequency.mapper;

import fr.orionbs.transaction_manager_server.adapter.output.persistence.frequency.entity.FrequencyEntity;
import fr.orionbs.transaction_manager_server.domain.model.Frequency;
import fr.orionbs.transaction_manager_server.domain.model.FrequencyEnum;
import org.springframework.stereotype.Component;

@Component
public class FrequencyPersistenceMapper {

    public Frequency toFrequency(FrequencyEntity frequencyEntity) {
        Frequency frequency = new Frequency();
        frequency.setId(frequencyEntity.getId());
        frequency.setFrequencyEnum(FrequencyEnum.valueOf(frequencyEntity.getValue()));
        return frequency;
    }

}
