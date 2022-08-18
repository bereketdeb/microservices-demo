package com.microservices.demo.elastic.query.client.service.impl;

import com.microservices.demo.common.util.CollectionsUtil;
import com.microservices.demo.config.ElasticQueryConfigData;
import com.microservices.demo.elastic.model.index.impl.TwitterIndexModel;
import com.microservices.demo.elastic.query.client.exception.ElasticQueryClientException;
import com.microservices.demo.elastic.query.client.repository.TwitterElasticsearchQueryRepository;
import com.microservices.demo.elastic.query.client.service.ElasticQueryClient;
import org.apache.lucene.util.CollectionUtil;
import org.elasticsearch.common.util.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Primary
@Service
public class TwitterElasticRepositoryQueryClient implements ElasticQueryClient<TwitterIndexModel> {

    private static final Logger LOG = LoggerFactory.getLogger(TwitterElasticRepositoryQueryClient.class);

    private final TwitterElasticsearchQueryRepository twitterElasticsearchQueryRepository;

    public TwitterElasticRepositoryQueryClient(TwitterElasticsearchQueryRepository twitterElasticsearchQueryRepository) {
        this.twitterElasticsearchQueryRepository = twitterElasticsearchQueryRepository;
    }

    @Override
    public TwitterIndexModel getIndexModelById(String id) {
        Optional<TwitterIndexModel> searchResult = twitterElasticsearchQueryRepository.findById(id);
        LOG.info("Document with id {} retrieved successfully", searchResult.orElseThrow(() -> new ElasticQueryClientException("No document found at elasticsearch with id"+ id)));
        return searchResult.get();
    }

    @Override
    public List<TwitterIndexModel> getIndexModelByText(String text) {
        List<TwitterIndexModel> searchResult = twitterElasticsearchQueryRepository.findByText(text);
        LOG.info("{} of document with text {} retrieved successfully", searchResult.size(), text);
        return searchResult;
    }

    @Override
    public List<TwitterIndexModel> getAllIndexModels() {
       // Iterable<TwitterIndexModel> all = twitterElasticsearchQueryRepository.findAll();
       List<TwitterIndexModel> searchResults = CollectionsUtil.getInstance().getListFromIterable(twitterElasticsearchQueryRepository.findAll());
       LOG.info("{} number of documents retrieved successfully", searchResults.size());
        return searchResults;
    }
}
