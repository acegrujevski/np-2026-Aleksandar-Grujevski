package kol1.zad13;

public class EvaluatorBuilder {



    private static final Evaluator NO_CRIMINAL_RECORD_EVALUATOR = a -> !a.hasCriminalRecord();

    private static final Evaluator MORE_EXPERIENCE_EVALUATOR = (a) -> a.getEmploymentYears() >= 10;

    private static final Evaluator MORE_CREDIT_SCORE_EVALUATOR = (a) -> a.getCreditScore() >= 500;

    private static final Evaluator NO_CRIMINAL_RECORD_AND_MORE_EXPERIENCE_EVALUATOR = NO_CRIMINAL_RECORD_EVALUATOR.and(MORE_EXPERIENCE_EVALUATOR);

    private static final Evaluator MORE_EXPERIENCE_AND_MORE_CREDIT_SCORE_EVALUATOR = MORE_EXPERIENCE_EVALUATOR.and(MORE_CREDIT_SCORE_EVALUATOR);

    private static final Evaluator NO_CRIMINAL_RECORD_AND_MORE_CREDIT_SCORE_EVALUATOR = NO_CRIMINAL_RECORD_EVALUATOR.and(MORE_CREDIT_SCORE_EVALUATOR);

    public static Evaluator build(Evaluator.TYPE type) throws InvalidEvaluation {

        switch (type){
            case NO_CRIMINAL_RECORD -> {
                return NO_CRIMINAL_RECORD_EVALUATOR;
            }
            case MORE_EXPERIENCE -> {
                return MORE_EXPERIENCE_EVALUATOR;
            }
            case MORE_CREDIT_SCORE -> {
                return MORE_CREDIT_SCORE_EVALUATOR;
            }
            case NO_CRIMINAL_RECORD_AND_MORE_EXPERIENCE -> {
                return NO_CRIMINAL_RECORD_AND_MORE_EXPERIENCE_EVALUATOR;
            }
            case MORE_EXPERIENCE_AND_MORE_CREDIT_SCORE -> {
                return MORE_EXPERIENCE_AND_MORE_CREDIT_SCORE_EVALUATOR;
            }
            case NO_CRIMINAL_RECORD_AND_MORE_CREDIT_SCORE -> {
                return NO_CRIMINAL_RECORD_AND_MORE_CREDIT_SCORE_EVALUATOR;
            }
            default -> throw new InvalidEvaluation("");
        }

    }
}
