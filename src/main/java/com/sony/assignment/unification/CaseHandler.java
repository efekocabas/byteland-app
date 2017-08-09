package com.sony.assignment.unification;

import com.sony.assignment.exception.InputException;
import com.sony.assignment.model.Byteland;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CaseHandler {

    private static final String SEPARATOR = " ";

    public void handle() {
        List<Byteland> cases = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int caseCount = getCaseCount(reader);

            for (int i = 0; i < caseCount; i++) {
                cases.add(getBytelandInfo(reader));
            }

            for (Byteland byteland : cases) {
                UnificationScheduler unificationScheduler = new UnificationScheduler(byteland);
                int stepCount = unificationScheduler.calculateStepCount();
                System.out.println(String.format("Step count: %d", stepCount));
            }
        } catch (IOException e) {
            System.out.println("Unknown error!");
        } catch (NumberFormatException e) {
            System.out.println("Please enter correct format!");
        } catch (InputException e) {
            System.out.println(e.getMessage());
        }
    }

    private int getCaseCount(BufferedReader reader) throws IOException {
        System.out.println("Please enter number of test cases: ");

        int caseCount = Integer.parseInt(reader.readLine());

        if (caseCount <= 0 || caseCount >= 1000) {
            throw new InputException("Case count must be between 1 and 999!");
        }

        return caseCount;
    }

    private Byteland getBytelandInfo(BufferedReader reader) throws IOException {
        System.out.println("Please enter number of cities: ");
        int cityCount = Integer.parseInt(reader.readLine());

        if (cityCount <= 2 || cityCount >= 600) {
            throw new InputException("City count must be between 2 and 600!");
        }

        System.out.println("Please enter road map between cities separated by spaces: ");
        String roads = reader.readLine();
        int[] roadMap = Arrays.stream(roads.split(SEPARATOR)).mapToInt(Integer::parseInt).toArray();

        if (roadMap.length != cityCount - 1) {
            throw new InputException("Road map count must be 1 less than city count!");
        }

        return new Byteland(cityCount, roadMap);
    }

}
