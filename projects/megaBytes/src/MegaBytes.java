public class MegaBytes {
    public void printMegaBytesAndKiloBytes(int kiloBytes) {
        int unit = 1024;
        int megaBytes = kiloBytes / unit;
        int remains = kiloBytes % unit;

        String result = kiloBytes < 0 ? "Invalid Value"
                : (kiloBytes + " KB = " + megaBytes + " MB and " + remains + " KB");

        System.out.println(result);
    }
}