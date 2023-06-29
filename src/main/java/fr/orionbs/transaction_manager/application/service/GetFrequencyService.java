package fr.orionbs.transaction_manager.application.service;

import fr.orionbs.transaction_manager.adapter.output.persistence.frequency.exception.UnknownFrequencyPersistenceException;
import fr.orionbs.transaction_manager.application.input.GetFrequencyUseCase;
import fr.orionbs.transaction_manager.application.output.SelectFrequencyPort;
import fr.orionbs.transaction_manager.domain.exception.UnknownFrequencyException;
import fr.orionbs.transaction_manager.domain.model.Frequency;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetFrequencyService implements GetFrequencyUseCase {

    private final SelectFrequencyPort selectFrequencyPort;

    @Override
    public List<Frequency> getFrequencies() {
        return selectFrequencyPort
                .selectFrequencies()
                .stream()
                .sorted(Comparator.comparing(Frequency::getFrequencyEnum))
                .collect(Collectors.toList());
    }

    @Override
    public Frequency getFrequencyById(Integer frequencyId) throws UnknownFrequencyException {
        try {
            return selectFrequencyPort.selectFrequencyById(frequencyId);
        } catch (UnknownFrequencyPersistenceException e) {
            throw new UnknownFrequencyException();
        }
    }
}
