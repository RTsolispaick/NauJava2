package homework;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * Необходимо сделать “GET” запрос на указанный адрес и обработать
 * ответ. Запрос выполняется на тестовый сервер по адресу
 * “https://httpbin.org/”. Сервер возвращает ответ в формате JSON. Из ответа
 * необходимо извлечь и вывести в консоль информацию в соответствии со
 * своим вариантом.
 * <p>
 * Вариант 1: Вывести только значение IP адреса с которого был сделан запрос
 * (запрос выполняется по адресу “https://httpbin.org/ip”).
 */
public class Task4 {
    private final URI uri = URI.create("https://httpbin.org/ip");

    private final ObjectMapper mapper = new ObjectMapper();

    /**
     * Внутренний класс DTO представляет структуру данных для хранения
     * значения IP-адреса, полученного из JSON-ответа.
     *
     * @param IP значение IP-адреса
     */
    private record DTO(
            @JsonProperty("origin") String IP
    ) {}

    /**
     * Решение задачи
     */
    public void solve()
    {
        try {
            // Выполняем запрос
            HttpClient client = HttpClient
                    .newHttpClient();
            HttpRequest request = HttpRequest
                    .newBuilder()
                    .uri(uri)
                    .build();
            HttpResponse<String> response = client.send(
                    request, HttpResponse.BodyHandlers.ofString()
            );

            // Преобразуем байтове представление JSON файла в объект DTO
            DTO dto = mapper.readValue(response.body(), DTO.class);

            // Вывод
            System.out.println("IP адрес из запроса: " + dto.IP);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Ошибка выполнения запроса", e);
        }
    }
}
