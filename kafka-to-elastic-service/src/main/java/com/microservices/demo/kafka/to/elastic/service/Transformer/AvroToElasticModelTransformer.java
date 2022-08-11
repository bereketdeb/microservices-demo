package com.microservices.demo.kafka.to.elastic.service.Transformer;

import com.microservices.demo.elastic.model.index.impl.TwitterIndexModel;
import com.microservices.demo.kafka.avro.model.TwitterAvroModel;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AvroToElasticModelTransformer {

    public List<TwitterIndexModel> getElasticModels(List<TwitterAvroModel> avroModels){

//        TwitterIndexModel model = new TwitterIndexModel();
//        List<TwitterIndexModel> models = new ArrayList<>();

//        for(TwitterAvroModel avro : avroModels){
//            System.out.println(avro.getText());
////            model.setId(String.valueOf(avro.getId()));
////            model.setText(avro.getText());
////            model.setCreatedAt(LocalDateTime.ofInstant(Instant.ofEpochMilli(avro.getCreatedAt()), ZoneId.systemDefault()));
////            model.setUserId(avro.getUserId());
////            models.add(model);
//        }
//        return models;
        return avroModels.stream()
                .map(avroModel -> TwitterIndexModel
                        .builder()
                        .userId(avroModel.getUserId())
                        .id(String.valueOf(avroModel.getId()))
                        .text(avroModel.getText())
                        .createdAt(LocalDateTime.ofInstant(Instant.ofEpochMilli(avroModel.getCreatedAt()), ZoneId.systemDefault()))
                        .build()
                        ).collect(Collectors.toList());
    }
}
