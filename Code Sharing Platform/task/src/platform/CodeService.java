package platform;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class CodeService {
    Code code;
    List<Code> codeList;
    Id id = new Id();
    private static final AtomicLong counter = new AtomicLong(0);

    public CodeService(List<Code> codeList) {
        this.codeList = codeList;
    }

    public Id addCode(Code newCode) {
        code = new Code(newCode.getCode());
        codeList.add(code);
        id.setId(Long.toString(counter.incrementAndGet()));

        return id;
    }

    public Code getCodeById(int id) {
        checkId(id);
        return codeList.get(id - 1);
    }

    public String getDate(int id) {
        checkId(id);
        return codeList.get(id - 1).getDate();
    }

    public String getCode(int id) {
        checkId(id);
        return codeList.get(id - 1).getCode();
    }

    public List<Code> getLatest() {
        List<Code> latestList = new ArrayList<>();

        if (codeList.isEmpty()) {
            throw new CodeNotFoundException();
        }

        int end = codeList.size() - 1;

        for (int i = 0; i < 10 && end >= 0; i++, end--) {
            latestList.add(codeList.get(end));
        }

        return latestList;
    }

    public void checkId(int id) {
        if (id < 1 || id > codeList.size()) {
            throw new CodeNotFoundException();
        }
    }
}
