package fr.orionbs.transaction_manager.application.input;

import fr.orionbs.transaction_manager.domain.exception.UnknownFrequencyException;
import fr.orionbs.transaction_manager.domain.model.Frequency;

import java.util.List;

public interface GetFrequencyUseCase {
    List<Frequency> getFrequencies();

    Frequency getFrequencyById(Integer frequencyId) throws UnknownFrequencyException;
}
