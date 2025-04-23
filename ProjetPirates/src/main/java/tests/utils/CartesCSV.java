package tests.utils;

import noyau.*;

import java.io.*;
import java.util.*;

public class CartesCSV {

    public static List<Carte> lireCartes(InputStream inputStream) {
        List<Carte> cartes = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String ligne = br.readLine(); // skip header

            while ((ligne = br.readLine()) != null) {
                String[] valeurs = parseCSVLine(ligne);// -1 keeps empty fields

                String nom = valeurs[0].replace("\"", "");
                String description = valeurs[1].replace("\"", "");
                String type = valeurs[2];

                int pvJoueur = parseIntSafe(valeurs[3]);
                int ppJoueur = parseIntSafe(valeurs[4]);
                int pvAdversaire = parseIntSafe(valeurs[5]);
                int ppAdversaire = parseIntSafe(valeurs[6]);

                boolean affecteNuit = parseBoolSafe(valeurs[7]);
                boolean piece = parseBoolSafe(valeurs[8]);

                Carte carte = null;

                switch (type.toLowerCase()) {
                    case "attaque":
                        carte = new CarteAttack(nom, description, ppJoueur, pvJoueur, ppAdversaire, pvAdversaire, affecteNuit, piece);
                        break;
                    case "defense":
                        carte = new CarteDefense(nom, description, ppJoueur, pvJoueur, affecteNuit);
                        break;
                    case "effet":
                        // carte = new CarteEffet(nom, description, ppJoueur, pvJoueur, affecteNuit);
                        break;
                    case "popularité":
                        carte = new CartePopularite(nom, description, ppJoueur, pvJoueur, piece);
                        break;
                    case "popularité + effet":
                        carte = new CartePopularite(nom, description, ppJoueur, pvJoueur, affecteNuit);
                        // carte = new CarteEffet(nom, description, ppJoueur, pvJoueur, affecteNuit);
                        break;
                    default:
                        System.out.println("Type inconnu pour la carte : " + nom);
                        continue; // skip this line
                }

                cartes.add(carte);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return cartes;
    }

    private static int parseIntSafe(String s) {
        if (s == null || s.trim().isEmpty()) return 0;
        return Integer.parseInt(s.trim());
    }

    private static boolean parseBoolSafe(String s) {
        if (s == null || s.trim().isEmpty()) return false;
        return s.trim().equals("1") || s.trim().equalsIgnoreCase("true");
    }

    private static String[] parseCSVLine(String line) {
        List<String> result = new ArrayList<>();
        boolean inQuotes = false;
        StringBuilder field = new StringBuilder();

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);

            if (c == '"') {
                inQuotes = !inQuotes;
            } else if (c == ',' && !inQuotes) {
                result.add(field.toString().trim());
                field.setLength(0);
            } else {
                field.append(c);
            }
        }

        result.add(field.toString().trim()); // Add the last field
        return result.toArray(new String[0]);
    }

}
