package mk.ukim.finki.wp.rentscoot.repository.jpa;

import mk.ukim.finki.wp.rentscoot.model.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface JpaPromotionRepository extends JpaRepository<Promotion,String> {
    List<Promotion> findByDiscountGreaterThanOrderByDiscountDesc(double discount);

    List<Promotion> findAllByValidFromBeforeOrderByDiscountDesc(LocalDate startReservationDate);

}
