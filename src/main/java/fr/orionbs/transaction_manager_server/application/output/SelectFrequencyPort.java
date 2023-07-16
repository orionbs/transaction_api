package fr.orionbs.transaction_manager_server.application.output;

import fr.orionbs.transaction_manager_server.adapter.output.persistence.frequency.exception.UnknownFrequencyPersistenceException;
import fr.orionbs.transaction_manager_server.domain.model.Frequency;

import java.util.List;

public interface SelectFrequencyPort {
    List<Frequency> selectFrequencies();

    Frequency selectFrequencyById(Integer frequencyId) throws UnknownFrequencyPersistenceException;
}
