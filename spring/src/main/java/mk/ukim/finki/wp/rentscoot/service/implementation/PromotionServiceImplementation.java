package mk.ukim.finki.wp.rentscoot.service.implementation;

import mk.ukim.finki.wp.rentscoot.model.Promotion;
import mk.ukim.finki.wp.rentscoot.service.PromotionService;
import org.apache.tomcat.jni.Local;

import java.time.LocalDate;
import java.util.List;

public class PromotionServiceImplementation implements PromotionService {

    @Override
    public Promotion createPromotion(String name, String description, double discount, LocalDate validFrom, Local validTo) {
        return null;
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
    public Promotion updatePromotion(String name, String description, double discount, LocalDate validFrom, Local validTo) {
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
