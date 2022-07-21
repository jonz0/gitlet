package gitlet;

import java.util.Map;

import static gitlet.Utils.*;

/** Driver class for Gitlet, a subset of the Git version-control system. */
public class Main {
// 266250c44641c4a0b1ad017ff95cdaaa0f0406e1
    /** Stores controls for gitlet and accesses methods via Repository object.
     *
     * Usage: java gitlet.Main ARGS, where ARGS contains
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
                    break;
                case "add":
                    r.exists();
                    r.add(args[1]);
                    break;
                case "commit":
                    r.exists();
                    if (args.length == 1) {
                        System.out.println("Please enter a commit message.");
                    } else if (args.length == 2) r.commit(args[1], null, false);
                    break;
                case "rm":
                    r.exists();
                    r.rm(args[1]);
                    break;
                case "log":
                    r.exists();
                    r.log();
                    break;
                case "global-log":
                    r.exists();
                    r.globalLog();
                    break;
                case "find":
                    r.exists();
                    if (args.length == 1) {
                        System.out.println("Enter a message to search for.");
                    } else r.find(args[1]);
                    break;
                case "status":
                    r.exists();
                    r.status();
                    break;
                case "checkout":
                    r.exists();
                    if (args.length == 2) {
                        r.checkoutBranch(args[1]);
                    }
                    if (args.length == 3) {
                        if (!args[1].equals("--")) System.out.println("Incorrect operands.");
                        r.checkoutFile(args[2]);
                    }
                    if (args.length == 4) {
                        if (!args[2].equals("--")) System.out.println("Incorrect operands.");
                        r.checkoutCommit(args[1], args[3]);
                    }
                    break;
                case "branch":
                    r.exists();
                    r.branch(args[1]);
                    break;
                case "rm-branch":
                    r.exists();
                    r.rmbranch(args[1]);
                    break;
                case "reset":
                    r.exists();
                    if (args.length != 2) Utils.exit("Enter a commit id to move to.");
                    r.reset(args[1]);
                    break;
                case "merge":
                    r.exists();
                    if (args.length != 2 ) Utils.exit("Enter a branch to merge.");
                    r.merge(args[1]);
                    break;
                default:
                    System.out.println("No command with that name exists.");
            }
        }
    }
}
