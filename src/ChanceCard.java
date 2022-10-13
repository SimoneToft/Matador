public class ChanceCard {
    String cardtext;
    int cardIncome;
    int cardExpense;
    public ChanceCard(String cardtext, int cardIncome, int cardExpense) {
        this.cardtext=cardtext;
        this.cardIncome=cardIncome;
        this.cardExpense=cardExpense;
    }
    public String getCardtext() {
        return cardtext;
    }

    public int getCardIncome() {
        return cardIncome;
    }

    public int getCardExpense() {
        return cardExpense;
    }
}
