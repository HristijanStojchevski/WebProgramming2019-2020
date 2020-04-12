package mk.ukim.finki.wp.rentscoot.service.implementation;

import mk.ukim.finki.wp.rentscoot.model.Promotion;
import mk.ukim.finki.wp.rentscoot.repository.PromotionRepository;
import mk.ukim.finki.wp.rentscoot.service.PromotionService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class PromotionServiceImplementation implements PromotionService {
    private final PromotionRepository promotionRepository;

    public PromotionServiceImplementation(PromotionRepository promotionRepository) {
        this.promotionRepository = promotionRepository;
    }

    @Override
    public Promotion createPromotion(String name, String description, double discount, LocalDate validFrom, LocalDate validTo) {
        Promotion promotion = new Promotion();
        promotion.setName(name);
        promotion.setDescription(description);
        promotion.setDiscount(discount);
        promotion.setValidFrom(validFrom);
        promotion.setValidTo(validTo);
        return this.promotionRepository.createPromotion(promotion);
    }

    @Override
    public List<Promotion> getAllPromotions() {
        return null;
    }

    @Override
    public Promotion getPromotion(String name) {
        return null;
    }

    @Override
    public Promotion updatePromotion(String name, String description, double discount, LocalDate validFrom, LocalDate validTo) {
        return null;
    }

    @Override
    public void deletePromotion(String name) {

    }

    @Override
    public List<Promotion> findBestDiscountPromotions(double discount) {
        return null;
    }

    @Override
    public Promotion findNewestPromotion() {
        return null;
    }

    @Override
    public List<Promotion> findAllValidPromotions(LocalDate from) {
        return null;
    }
}
