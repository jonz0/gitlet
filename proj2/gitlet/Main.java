package gitlet;

/** Driver class for Gitlet, a subset of the Git version-control system.
 *  @author TODO
 */
public class Main {

    /** Usage: java gitlet.Main ARGS, where ARGS contains
     *  <COMMAND> <OPERAND1> <OPERAND2> ... 
     */
    public static void main(String[] args) {
        // TODO: what if args is empty?
        Repository r = new Repository();
        if (args.length == 0) {
            System.out.println("Please enter a command.");
        } else {
            switch (args[0]) {
                case "init":
                    System.getProperty("user.dir");
                    r.init();
                    Commit initial = new Commit("initial commit", null, null);
                    break;
                case "add":
                    r.add(args[1]);
                    break;
                case "commit":
                    if (args.length < 2) r.commit(args[0], null);
                    else r.commit(args[0], args[1]);
                    break;
                case "rm":

                    break;
                case "log":

                    break;
                case "global-log":

                    break;
                case "find":

                    break;
                case "status":

                    break;
                case "checkout":

                    break;
                case "branch":

                    break;
                case "rm-branch":

                    break;
                case "reset":

                    break;
                case "merge":

                    break;
                default:
                    System.out.println("You must enter a command.");
            }
        }
    }
}
