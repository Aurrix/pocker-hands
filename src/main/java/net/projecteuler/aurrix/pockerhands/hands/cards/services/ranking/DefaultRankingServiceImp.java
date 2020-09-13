package net.projecteuler.aurrix.pockerhands.hands.cards.services.ranking;

import net.projecteuler.aurrix.pockerhands.hands.Hand;
import net.projecteuler.aurrix.pockerhands.hands.cards.Card;
import net.projecteuler.aurrix.pockerhands.hands.cards.services.RankingService;
import net.projecteuler.aurrix.pockerhands.hands.ranks.Rank;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class DefaultRankingServiceImp implements RankingService {

    private final List<Rank> ranks;

    public DefaultRankingServiceImp(List<Rank> ranks) {
        this.ranks = ranks;
        Collections.sort(this.ranks);
    }

    @Override
    public int rankHand(Hand hand) {
        for (Rank rank : ranks) {
            if (rank.checks(hand)) {
                hand.setRank(rank.getName());
                hand.setScore(rank.getHandScore(hand));
                break;
            }
        }
        if (hand.getScore() == 0) hand.setScore(getHighestCardValue(hand));
        return hand.getScore();
    }

    @Override
    public int getHighestCardValue(Hand hand) {
        int highest = 0;
        for (Card card : hand.getCards()) {
            if (card.getValue().value > highest) highest = card.getValue().value;
        }
        return highest;
    }
}
