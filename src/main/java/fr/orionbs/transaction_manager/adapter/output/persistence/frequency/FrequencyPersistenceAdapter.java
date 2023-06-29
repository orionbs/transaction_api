package fr.orionbs.transaction_manager.adapter.output.persistence.frequency;

import fr.orionbs.transaction_manager.adapter.output.persistence.frequency.exception.UnknownFrequencyPersistenceException;
import fr.orionbs.transaction_manager.adapter.output.persistence.frequency.mapper.FrequencyPersistenceMapper;
import fr.orionbs.transaction_manager.adapter.output.persistence.frequency.repository.FrequencyRepository;
import fr.orionbs.transaction_manager.application.output.SelectFrequencyPort;
import fr.orionbs.transaction_manager.domain.model.Frequency;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class FrequencyPersistenceAdapter implements SelectFrequencyPort {

    private final FrequencyRepository frequencyRepository;
    private final FrequencyPersistenceMapper frequencyPersistenceMapper;

    @Override
    public List<Frequency> selectFrequencies() {
        return frequencyRepository
                .findAll()
                .stream()
                .map(frequencyPersistenceMapper::toFrequency)
                .collect(Collectors.toList());
    }

    @Override
    public Frequency selectFrequencyById(Integer frequencyId) throws UnknownFrequencyPersistenceException {
        return frequencyRepository
                .findById(frequencyId)
                .map(frequencyPersistenceMapper::toFrequency)
                .orElseThrow(UnknownFrequencyPersistenceException::new);
    }
}
