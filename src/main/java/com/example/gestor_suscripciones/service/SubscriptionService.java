package com.example.gestor_suscripciones.service;

import com.example.gestor_suscripciones.model.Subscription;
import com.example.gestor_suscripciones.repository.SubscriptionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;

    public SubscriptionService(SubscriptionRepository subscriptionRepo) {
        this.subscriptionRepository = subscriptionRepo;
    }

    // Create
    public Subscription createSubscription(Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }

    // Read
    public List<Subscription> getSubscription() {
        return subscriptionRepository.findAll();
    }

    public Subscription getSubscriptionById(UUID id) {
        return subscriptionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Suscripción no encontrada"));
    }


}
