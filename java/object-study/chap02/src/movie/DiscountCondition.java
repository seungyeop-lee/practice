package movie;

public interface DiscountCondition {
    public boolean isSatisfiedBy(Screening screening);
}
