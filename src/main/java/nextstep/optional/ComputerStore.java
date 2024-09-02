package nextstep.optional;

import nextstep.optional.Computer.Soundcard;
import nextstep.optional.Computer.USB;

import java.util.Optional;

public class ComputerStore {
    public static final String UNKNOWN_VERSION = "UNKNOWN";

    public static String getVersion(Computer computer) {
        String version = UNKNOWN_VERSION;
        if (computer != null) {
            Soundcard soundcard = computer.getSoundcard();
            if (soundcard != null) {
                USB usb = soundcard.getUsb();
                if (usb != null) {
                    version = usb.getVersion();
                }
            }
        }
        return version;
    }

    public static String getVersionOptional(Computer computer) {
        Optional<Computer> optional = Optional.ofNullable(computer);
        return optional.stream()
                .map(Computer::getSoundcard)
                .filter(item -> item != null)
                .map(Soundcard::getUsb)
                .filter(item -> item != null)
                .map(USB::getVersion)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("잘 못된 데이터입니다."));
    }
}
