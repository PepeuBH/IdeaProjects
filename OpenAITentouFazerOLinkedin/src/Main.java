import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


class Candidate {
    private String name;
    private int[] skills;
    private int[] levels;

    public Candidate(String name, int[] skills, int[] levels) {
        this.name = name;
        this.skills = skills;
        this.levels = levels;
    }

    public String getName() {
        return name;
    }

    public int[] getSkills() {
        return skills;
    }

    public int[] getLevels() {
        return levels;
    }


}
public class TalentBank {
    private static final String SKILLS_FILE = "skills.txt";
    private static final String CANDIDATES_FILE = "candidates.txt";
    private List<String> skills;
    private List<Candidate> candidates;

    public TalentBank() {
        skills = new ArrayList<>();
        candidates = new ArrayList<>();
        loadSkills();
        loadCandidates();
    }

    private void loadSkills() {
        try (BufferedReader br = new BufferedReader(new FileReader(SKILLS_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                skills.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading skills file: " + e.getMessage());
        }
    }

    private void loadCandidates() {
        try (BufferedReader br = new BufferedReader(new FileReader(CANDIDATES_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                String name = parts[0];
                int[] levels = new int[parts.length - 1];
                for (int i = 1; i < parts.length; i++) {
                    levels[i - 1] = Integer.parseInt(parts[i]);
                }
                candidates.add(new Candidate(name, levels));
            }
        } catch (IOException e) {
            System.out.println("Error reading candidates file: " + e.getMessage());
        }
    }

    public Candidate getBestCandidateForSkill(String skill) {
        int index = skills.indexOf(skill);
        Candidate bestCandidate = null;
        int bestLevel = -1;
        for (Candidate candidate : candidates) {
            int level = candidate.getLevels()[index];
            if (level > bestLevel) {
                bestCandidate = candidate;
                bestLevel = level;
            }
        }
        return bestCandidate;
    }

    public Candidate getBestCandidateForSkills(String skill1, String skill2) {
        int index1 = skills.indexOf(skill1);
        int index2 = skills.indexOf(skill2);
        Candidate bestCandidate = null;
        int bestScore = -1;
        for (Candidate candidate : candidates) {
            int score = candidate.getLevels()[index1] + candidate.getLevels()[index2];
            if (score > bestScore) {
                bestCandidate = candidate;
                bestScore = score;
            }
        }
        return bestCandidate;
    }

    public Candidate getMostInterestingCandidate() {
        Candidate bestCandidate = null;
        int bestScore = -1;
        for (Candidate candidate : candidates) {
            int score = 0;
        }
    }
}