# Testing ala UNIT-Testing 
Demonstration of some testing practices. Just for know-how transfer and collaboration.

## Problem
We wrote some (Java) classes and we want to be sure that they do what they should do!
So we should think about to write tests, but how?
What we probably want from our tests?
* We want fast tests, because we want to have fast feedback from our CI infrastructure.
* We want to have a high code-coverage, so we can be sure we do not have some failures in the code.

## Let us try
Writing real unit tests can be very easy, if we have simple classes like "junit-testing/Calculator". This is because the Calculator class has no real dependencies to other classes for now. So we can do a simple test like this:

	public class CalculatorTest {
	private Calculator calculator;
	
		@Before
		public void setup() {
			calculator = new Calculator();
		}
		
		@Test
		public void addPositiveValues() {
			assertThat(calculator.add(1, 1), Matchers.equalTo(2));
		}
		
		@Test
		public void addOneToMaxInt() {
			assertThat(calculator.add(1, Integer.MAX_VALUE), Matchers.allOf(
					Matchers.equalTo(Integer.MAX_VALUE+1),
					Matchers.greaterThan(0)));
		}
		
		@Test
		public void convertDecToHex() throws Exception {
			assertThat(calculator.toHex(Integer.MAX_VALUE),
			Matchers.stringContainsInOrder(Arrays.asList("7","f","f","f","f","f","f")));
		}
	}

But wait! Calculator is as simple as possible, normally we have more complex code how can we test such code.

## Let's try a more complex sample
Looking at "bowling-scoreboard", we see a lot of more classes which calculates the score board. Starting easiest-first we can write some test for Try. It is very simple, isn't it. We also found some test for Frame. But when we look at Game the test will get more complex. So It is very hard to find all possible situations. 
No Problem, this is why we wrote also tests for Try and Frame. So we can be sure that Try and Frame are correct and safe ;-). Now we should concentrate only on the code in Game and finally we wrote a test like this:

	@Test
	public void calculateFullGame() throws Exception {
		Game game = new Game();
		game.addTry(5).addTry(5)
		    .addTry(10)
		    .addTry(10)
		    .addTry(10)
		    .addTry(9).addTry(0)
		    .addTry(0).addTry(8)
		    .addTry(9).addTry(0)
		    .addTry(7).addTry(0)
		    .addTry(1).addTry(8)
		    .addTry(1).addTry(2);
		assertThat(game.calculate(), Matchers.equalTo(143));
	}

But wait! What if we have more complex classes to tests with many dependencies to others, like classes which get some other classes injected (e.g. with Spring).
