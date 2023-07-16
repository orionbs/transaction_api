package fr.orionbs.transaction_manager_server.application.input;

import fr.orionbs.transaction_manager_server.domain.exception.UnknownFrequencyException;
import fr.orionbs.transaction_manager_server.domain.model.Frequency;

import java.util.List;

public interface GetFrequencyUseCase {
    List<Frequency> getFrequencies();

    Frequency getFrequencyById(Integer frequencyId) throws UnknownFrequencyException;
}
