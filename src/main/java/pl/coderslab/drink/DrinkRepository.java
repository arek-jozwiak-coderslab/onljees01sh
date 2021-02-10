package pl.coderslab.drink;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DrinkRepository extends JpaRepository<Drink, Long> {

    List<Drink> findAllByRating(int rating);
    List<Drink> findByName(String name);
    List<Drink> findByCategory(DrinkCategory category);
    List<Drink> findByCategoryId(Long id);


}
