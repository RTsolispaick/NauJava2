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
    private static final URI uri = URI.create("https://httpbin.org/ip");

    private static final ObjectMapper mapper = new ObjectMapper();

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
     * Выполняет HTTP GET-запрос по указанному URI и возвращает
     * ответ в виде массива байтов.
     *
     * @param uri URI, на который будет выполнен запрос
     * @return массив байтов, содержащий тело ответа
     */
    private static byte[] makeRequest(URI uri) {
        try (HttpClient client = HttpClient.newHttpClient()) {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .build();
            HttpResponse<byte[]> response = client.send(request,
                    HttpResponse.BodyHandlers.ofByteArray());
            return response.body();
        } catch (Exception e) {
            throw new RuntimeException("Не удалось выполнить запрос", e);
        }
    }

    /**
     * Преобразует массив байтов JSON в объект DTO.
     *
     * @param jsonInByte массив байтов, содержащий JSON
     * @return объект DTO, заполненный данными из JSON
     */
    private static DTO getDTO(byte[] jsonInByte) {
        try {
            return mapper.readValue(jsonInByte, DTO.class);
        } catch (IOException e) {
            throw new RuntimeException("Не удалось создать DTO", e);
        }
    }

    public static void main(String[] args)
    {
        byte[] bodyOfRequest = makeRequest(uri);

        DTO dto = getDTO(bodyOfRequest);

        System.out.println(dto.IP);
    }
}
