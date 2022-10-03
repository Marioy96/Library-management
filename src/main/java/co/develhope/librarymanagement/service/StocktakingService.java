package co.develhope.librarymanagement.service;

import co.develhope.librarymanagement.repository.StocktakingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StocktakingService {

    @Autowired
    private StocktakingRepository stocktakingRepository;
}
