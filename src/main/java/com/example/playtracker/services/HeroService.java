package com.example.playtracker.services;

import com.example.playtracker.entities.HeroEntity;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class HeroService {
  private static final String  API_URL =
          "http://api.steampowered.com/IEconDOTA2_570/GetHeroes/v1?key=C7A2D54BAFCF77974DC25CB1AD4D11E&language=en";

  public List<HeroEntity> fetchHeroes() {
    List<HeroEntity> heroes = new ArrayList<>();
    try {
      // Создание HTTP-запроса
      HttpClient client = HttpClient.newHttpClient();
      HttpRequest request = HttpRequest.newBuilder()
              .uri(new java.net.URI(API_URL))
              .GET()
              .build();

      // Отправка запроса и получение ответа
      HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
      String responseBody = response.body();

      // Парсинг JSON-ответа
      ObjectMapper objectMapper = new ObjectMapper();
      JsonNode rootNode = objectMapper.readTree(responseBody);
      JsonNode heroesNode = rootNode.path("result").path("heroes");

      // Заполнение списка героев
      for (JsonNode heroNode : heroesNode) {
        HeroEntity hero = new HeroEntity();
        hero.setId(heroNode.path("id").asInt());
        hero.setName(heroNode.path("name").asText());
        hero.setLocalizedName(heroNode.path("localized_name").asText());
        heroes.add(hero);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return heroes;
  }

}

