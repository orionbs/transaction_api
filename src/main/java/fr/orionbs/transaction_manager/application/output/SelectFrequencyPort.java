package fr.orionbs.transaction_manager.application.output;

import fr.orionbs.transaction_manager.adapter.output.persistence.frequency.exception.UnknownFrequencyPersistenceException;
import fr.orionbs.transaction_manager.domain.model.Frequency;

import java.util.List;

public interface SelectFrequencyPort {
    List<Frequency> selectFrequencies();

    Frequency selectFrequencyById(Integer frequencyId) throws UnknownFrequencyPersistenceException;
}
