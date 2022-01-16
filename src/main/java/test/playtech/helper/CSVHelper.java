package test.playtech.helper;

import test.playtech.dto.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class CSVHelper {

    public static List<SessionWonWageredDto> generateSessionWWCSV(List<EventDataDTO> eventDataDTOSList) {

        Map<Integer, Map<Integer, SessionWonWageredDto>> eventDataDTOMap = eventDataDTOSList.stream()
                .collect(groupingBy(EventDataDTO::getSessionId, groupingBy(EventDataDTO::getPlayerId,
                        collectingAndThen(toList(), list -> {
                            double amountWon = list.stream()
                                    .filter(amt -> amt.getChapter().equalsIgnoreCase("WIN"))
                                    .mapToDouble(EventDataDTO::getAmount).sum();
                            double amountWagered = list.stream()
                                    .filter(amt -> amt.getChapter().equalsIgnoreCase("BET")).mapToDouble(EventDataDTO::getAmount).sum();
                            int sessionId = list.get(0).getSessionId();
                            return new SessionWonWageredDto(0, sessionId, amountWon, amountWagered);
                        }))));
        eventDataDTOMap.entrySet().stream().forEach(playerMap -> playerMap.getValue().entrySet().stream()
                .forEach(mapPlayer -> mapPlayer.getValue().setPlayerId(mapPlayer.getKey())));
        List<SessionWonWageredDto> sessionWonWageredDtoList = new ArrayList<>();
        eventDataDTOMap.entrySet().stream().forEach(playerMap -> playerMap.getValue().entrySet().stream()
                .forEach(finalList -> sessionWonWageredDtoList.add(finalList.getValue())));

        return sessionWonWageredDtoList;

    }

    public static List<GameWonWageredDTO> generateGameWWCSV(List<EventDataDTO> eventDataDTOSList) {
        Map<String, Map<Integer, GameWonWageredDTO>> eventDataDTOMap = eventDataDTOSList.stream()
                .collect(groupingBy(EventDataDTO::getGameName, groupingBy(EventDataDTO::getPlayerId,
                        collectingAndThen(toList(), list -> {
                            double amountWon = list.stream()
                                    .filter(amt -> amt.getChapter().equalsIgnoreCase("WIN")).mapToDouble(EventDataDTO::getAmount).sum();
                            double amountWagered = list.stream()
                                    .filter(amt -> amt.getChapter().equalsIgnoreCase("BET")).mapToDouble(EventDataDTO::getAmount).sum();
                            String gameName = list.get(0).getGameName();
                            return new GameWonWageredDTO(0, gameName, amountWon, amountWagered);
                        }))));

        List<GameWonWageredDTO> gameWonWageredDTOList = new ArrayList<>();
        eventDataDTOMap.entrySet().stream().forEach(playerMap -> playerMap.getValue().entrySet().stream()
                .forEach(mapPlayer -> mapPlayer.getValue().setPlayerId(mapPlayer.getKey())));
        eventDataDTOMap.entrySet().stream().forEach(playerMap -> playerMap.getValue().entrySet().stream()
                .forEach(finalList -> gameWonWageredDTOList.add(finalList.getValue())));
        return gameWonWageredDTOList;
    }

    public static List<GameSessionWonWageredDTO> generateGameSessionWWCSV(List<EventDataDTO> eventDataDTOSList) {
        Map<String, Map<Integer, Map<Integer, GameSessionWonWageredDTO>>> eventDataDTOMap = eventDataDTOSList.stream()
                .collect(groupingBy(EventDataDTO::getGameName, groupingBy(EventDataDTO::getPlayerId, groupingBy(EventDataDTO::getSessionId,
                        collectingAndThen(toList(), list -> {
                            double amountWon = list.stream()
                                    .filter(amt -> amt.getChapter().equalsIgnoreCase("WIN")).mapToDouble(EventDataDTO::getAmount).sum();
                            double amountWagered = list.stream()
                                    .filter(amt -> amt.getChapter().equalsIgnoreCase("BET")).mapToDouble(EventDataDTO::getAmount).sum();
                            String gameName = list.get(0).getGameName();
                            return new GameSessionWonWageredDTO(0,0, gameName, amountWon, amountWagered);
                        })))));
        List<GameSessionWonWageredDTO> gameSessionWonWageredDTOList = new ArrayList<>();

        eventDataDTOMap.entrySet().stream().forEach(gameMap -> gameMap.getValue().entrySet().stream().
                forEach(playerMap -> playerMap.getValue().entrySet().stream()
                .forEach(mapPlayer -> {
                    mapPlayer.getValue().setPlayerId(playerMap.getKey());
                mapPlayer.getValue().setSessionId(mapPlayer.getKey());
                }
                )));
        eventDataDTOMap.entrySet().stream().forEach(gameMap -> gameMap.getValue().entrySet().stream().
                forEach(playerMap -> playerMap.getValue().entrySet().stream()
                .forEach(finalList -> gameSessionWonWageredDTOList.add(finalList.getValue()))));

        return gameSessionWonWageredDTOList;
    }

    public static List<ProfitPlayerDTO> generateProfitPlayerCSV(List<EventDataDTO> eventDataDTOSList) {
        Map<Integer, ProfitPlayerDTO> eventDataDTOMap = eventDataDTOSList.stream()
                .collect(groupingBy(EventDataDTO::getPlayerId,
                        collectingAndThen(toList(), list -> {
                            double amountWon = list.stream()
                                    .filter(amt -> amt.getChapter().equalsIgnoreCase("WIN")).mapToDouble(EventDataDTO::getAmount).sum();
                            double amountWagered = list.stream()
                                    .filter(amt -> amt.getChapter().equalsIgnoreCase("BET")).mapToDouble(EventDataDTO::getAmount).sum();
                            double profit = amountWagered - amountWon;
                            return new ProfitPlayerDTO(0, amountWon, amountWagered, profit);
                        })));

        List<ProfitPlayerDTO> profitPlayerDTOArrayList = new ArrayList<>();
        eventDataDTOMap.entrySet().stream().forEach(mapPlayer -> mapPlayer.getValue().setPlayerId(mapPlayer.getKey()));
        eventDataDTOMap.entrySet().stream()
                .forEach(finalList -> profitPlayerDTOArrayList.add(finalList.getValue()));
        profitPlayerDTOArrayList.sort(Comparator.comparingDouble(ProfitPlayerDTO::getProfit).reversed());

        return profitPlayerDTOArrayList.stream().limit(5).collect(toList());
    }
}