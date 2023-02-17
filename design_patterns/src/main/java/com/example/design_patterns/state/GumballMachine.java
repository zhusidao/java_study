package com.example.design_patterns.state;

import java.util.Random;

/**
 * 状态模式允许对象在内部状态改变时改变它的行为，对象看起来好想修改了它的类。
 *
 * context对象会随着时间而改变状态，而任务状态都是定义好的
 *
 * @author ZhuSiDao
 * @date 2020/11/24
 */
public abstract class GumballMachine {
    final static int SOLD_OUT = 0;
    final static int NO_QUARTER = 1;
    final static int HAS_QUARTER = 2;
    final static int SOLD = 3;

    int state = SOLD_OUT;
    int count = 0;

    public GumballMachine(int count) {
        this.count = count;
        if (count > 0) {
            state = NO_QUARTER;
        }
    }

    /**
     * 投25分
     */
    public void insertQuarter() {
        if (state == HAS_QUARTER) {
            System.out.println("you can't insert another quarter");
        } else if (state == NO_QUARTER) {
            state = HAS_QUARTER;
            System.out.println("you inserted a quarter");
        } else if (state == SOLD_OUT) {
            System.out.println("you can't insert a quarter, the machine is sold out");
        } else if (state == SOLD) {
            System.out.println("Please wait, we're already giving you a gumball");
        }
    }

    /**
     * 回25分
     */
    public void ejectQuarter() {
        if (state == HAS_QUARTER) {
            System.out.println("Quart return");
            state = NO_QUARTER;
        } else if (state == NO_QUARTER) {
            System.out.println("you haven't inserted a quarter");
        } else if (state == SOLD) {
            System.out.println("sorry you already turned the crank");
        } else if (state == SOLD_OUT) {
            System.out.println("you can't eject, you haven't inserted a quarter yet");
        }
    }

    /**
     * 转动曲柄
     */
    public void turnCrank() {
        if (state == SOLD) {
            System.out.println("Turning twice doesn't get you another gumball");
        } else if (state == NO_QUARTER) {
            System.out.println("you turned but there's no quarter");
        } else if (state == SOLD_OUT) {
            System.out.println("you turned, but there are no gumballs");
        } else if (state == HAS_QUARTER) {
            System.out.println("you turned...");
            state = SOLD;
            // 分发糖果
            dispense();
        }
    }

    /**
     * 分发糖果
     */
    public void dispense() {
        if (state == SOLD) {
            System.out.println("A gumball comes rolling out the slot");
            count--;
            if (count == 0) {
                System.out.println("Oops, out of gumballs");
            } else {
                state = NO_QUARTER;
            }
        } else if (state == NO_QUARTER) {
            System.out.println("you need to pay first");
        } else if (state == SOLD_OUT) {
            System.out.println("No gumball dispensed");
        } else if (state == HAS_QUARTER) {
            System.out.println("No gumball dispensed");
        }
    }
}

/**
 * 状态模式
 */
class GumBallMachine {
    State soldOutState;
    State noQuarterState;
    State hasQuarterState;
    State soldState;
    State winneState;

    State state = soldOutState;
    int count = 0;

    public GumBallMachine(int numberGunballs) {
        this.soldOutState = new SoldOutState(this);
        this.noQuarterState = new NoQuarterState(this);
        this.hasQuarterState = new HasQuarterState(this);
        this.soldState = new SoldState(this);
        this.winneState = new WinnerState(this);
        this.count = numberGunballs;
        if (numberGunballs > 0) {
            state = noQuarterState;
        }
    }

    public void insertQuarter() {
        state.insertQuarter();
    }

    public void ejectQuarter() {
        state.ejectQuarter();
    }

    public void turnCrank() {
        state.turnCrank();
        state.dispense();
    }

    public void releaseBall() {
        System.out.println("A gumball comes rolling out the slot...");
        if (count != 0) {
            count -= 1;
        }
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public State getNoQuarterState() {
        return noQuarterState;
    }

    public State getHasQuarterState() {
        return hasQuarterState;
    }

    public State getSoldState() {
        return soldState;
    }

    public State getWinneState() {
        return winneState;
    }

    public State getState() {
        return state;
    }

    public int getCount() {
        return count;
    }
}

class SoldOutState implements State {

    GumBallMachine gumBallMachine;

    public SoldOutState(GumBallMachine gumBallMachine) {
        this.gumBallMachine = gumBallMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("you can't insert a quarter, the machine is sold out");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("you can't eject, you haven't inserted a quarter yet");
    }

    @Override
    public void turnCrank() {
        System.out.println("you turned, but there are no gumballs");
    }

    @Override
    public void dispense() {
        System.out.println("No gumball dispensed");
    }
}

class NoQuarterState implements State {

    GumBallMachine gumBallMachine;

    public NoQuarterState(GumBallMachine gumBallMachine) {
        this.gumBallMachine = gumBallMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("you inserted a quarter");
        gumBallMachine.setState(gumBallMachine.getHasQuarterState());
    }

    @Override
    public void ejectQuarter() {
        System.out.println("you haven't inserted a quarter");
    }

    @Override
    public void turnCrank() {
        System.out.println("you turned but there's no quarter");
    }

    @Override
    public void dispense() {
        System.out.println("you need to pay first");
    }

}

class HasQuarterState implements State {

    Random random = new Random(System.currentTimeMillis());
    GumBallMachine gumBallMachine;

    public HasQuarterState(GumBallMachine gumBallMachine) {
        this.gumBallMachine = gumBallMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("you haven't inserted a quarter");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("quarter returned");
        gumBallMachine.setState(gumBallMachine.getNoQuarterState());
    }

    @Override
    public void turnCrank() {
        System.out.println("you turned...");
        int winner = random.nextInt(10);
        if (winner == 0 && gumBallMachine.getCount() > 1) {
            gumBallMachine.setState(gumBallMachine.getWinneState());
        } else {
            gumBallMachine.setState(gumBallMachine.getSoldState());
        }
    }

    @Override
    public void dispense() {
        System.out.println("no gumball dispensed");
    }
}

class SoldState implements State {

    GumBallMachine gumBallMachine;

    public SoldState(GumBallMachine gumBallMachine) {
        this.gumBallMachine = gumBallMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("Please wait, we're already giving a gumball");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("sorry, you already turned the crank");
    }

    @Override
    public void turnCrank() {
        System.out.println("turning twice doesn't get you another gumball");
    }

    @Override
    public void dispense() {
        gumBallMachine.releaseBall();
        if (gumBallMachine.getCount() > 0) {
            gumBallMachine.setState(gumBallMachine.getNoQuarterState());
        } else {
            System.out.println("Oops, out of gumballs");
            gumBallMachine.setState(gumBallMachine.getSoldOutState());
        }
    }
}

class WinnerState implements State {

    GumBallMachine gumBallMachine;

    public WinnerState(GumBallMachine gumBallMachine) {
        this.gumBallMachine = gumBallMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("Please wait, we're already giving a gumball");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("sorry, you already turned the crank");
    }

    @Override
    public void turnCrank() {
        System.out.println("turning twice doesn't get you another gumball");
    }

    @Override
    public void dispense() {
        System.out.println("you're a winner! you get two gumballs for you quarter");
        gumBallMachine.releaseBall();
        if (gumBallMachine.getCount() == 0) {
            gumBallMachine.setState(gumBallMachine.getSoldOutState());
        } else {
            gumBallMachine.releaseBall();
            if (gumBallMachine.getCount() > 0) {
                gumBallMachine.setState(gumBallMachine.getNoQuarterState());
            } else {
                System.out.println("Oops, out of gumballs");
                gumBallMachine.setState(gumBallMachine.getSoldOutState());
            }
        }
    }
}

interface State {
    void insertQuarter();

    void ejectQuarter();

    void turnCrank();

    void dispense();
}