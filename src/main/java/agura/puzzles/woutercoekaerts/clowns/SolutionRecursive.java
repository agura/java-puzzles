package agura.puzzles.woutercoekaerts.clowns;

/**
 * Recursive solution. More elegant :)
 *
 * @author Andrey Gura
 */
public class SolutionRecursive {
    private static final int TARGET_CLOWNS_AMOUNT = 20;
    private static int clownsCount = 0;
    private static final Volkswagen vw = new Volkswagen();

    public static void main(String args[]) {
        vw.add(new RecursiveClown());
        vw.done();
    }

    private static class RecursiveClown extends Clown {
        @Override
        public int hashCode() {
            if (++clownsCount < TARGET_CLOWNS_AMOUNT) {
                vw.add(new RecursiveClown());
            }
            return super.hashCode();
        }
    }
}
