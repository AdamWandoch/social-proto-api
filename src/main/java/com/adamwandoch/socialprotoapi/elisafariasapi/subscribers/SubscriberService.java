package com.adamwandoch.socialprotoapi.elisafariasapi.subscribers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SubscriberService {

    @Autowired
    private SubscriberRepository subscriberRepository;

    public SubscriberService(SubscriberRepository subscriberRepository) {
        this.subscriberRepository = subscriberRepository;
    }

    public boolean addSubscriber(SubscriberEntity subscriber) {

        if (subscriberRepository.findByEmail(subscriber.getEmail()).isPresent()) {
            return false;
        }
        subscriberRepository.save(subscriber);
        return true;
    }

    public SubscriberEntity getSubscriberByEmail(SubscriberEntity subscriber) {
        if (subscriberRepository.findByEmail(subscriber.getEmail()).isPresent()) {
            return subscriberRepository.findByEmail(subscriber.getEmail()).get();
        }
        return null;
    }

    public SubscriberEntity getSubscriberById(SubscriberEntity subscriber) {
        if (subscriberRepository.findById(subscriber.getId()).isPresent()) {
            return subscriberRepository.findById(subscriber.getId()).get();
        }
        return null;
    }

    public ArrayList<SubscriberEntity> getAllSubscribers() {
        ArrayList<SubscriberEntity> subscribers = new ArrayList<>();
            subscriberRepository.findAll().forEach(subscribers::add);
            return subscribers;
    }
}
