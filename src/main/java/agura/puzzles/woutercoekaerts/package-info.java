/**
 * Contains puzzles from Wouter Coekaerts blog (<a href="http://wouter.coekaerts.be">http://wouter.coekaerts.be</a>)
 *
 * <h3>Puzzles</h3>
 *
 * <p>
 * This is a series of Java puzzles that put your Java skills to the test, in a challenging and fun way!
 * A puzzle consists of some given Java code with a line in it that seems to be impossible to reach. It&apos;s up to you to find the hole in it, abuse a subtle behavior of Java to make execution reach that line anyways.
 * </p>
 *
 * <h3>Rules</h3>
 *
 * <p><b>Short version:</b> You must run the program with java -Djava.security.manager the.MainClass. Any cheating in the content of your .java file is allowed; it is the whole point of the puzzle. Cheating the (compiler or runtime) environment from outside your code is not allowed.</p>
 *
 * <p>If that&apos;s clear, then start puzzling now and forget about the rest. But if that still leaves you in doubt:
 * <ol>
 *     <li><em>The goal of each puzzle is to reach a certain line in the exact given class.</em> Reaching the line in a modified copy of the given classes does not count.</li>
 *     <li>You can use any <em>unmodified Java compiler and runtime</em>. Puzzles are not intended to be version-specific so I recommend you just use something recent like JDK 6 or 7.</li>
 *     <li><em>No extra arguments to the compiler or runtime</em> except for the <code>-Djava.security.manager</code> are allowed. The security manager option is there to prevent things such as setAccessible that would spoil the fun. If you like to work from within your IDE, add that option to the JVM arguments of the run configuration. If you don&apos;t change any other funky settings you&apos;re good to go.</li>
 *     <li>The solution consists of <em>just the content of the one <code>.java</code> file</em>. Other files may not be modified, and if any extra steps or tweaks are needed to be able to make it work, it&apos;s not a valid solution.</li>
 *     <li>Within that code <i>everything</i> is allowed, except exploiting known security holes in Java itself. You can write ugly things that would not be acceptable in any decent program. If you really feel like it and can pull it off, you can make a classloader subclass dance naked on a reflective error. But it&apos;s unlikely to help you get closer to the solution.</li>
 * </ol>
 * </p>
 *
 * <p>
 * See original rules post - <a href="http://wouter.coekaerts.be/puzzles">http://wouter.coekaerts.be/puzzles</a>
 * </p>
 */
package agura.puzzles.woutercoekaerts;