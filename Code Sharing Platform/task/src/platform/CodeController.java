package platform;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CodeController {

    @Autowired
    CodeService codeService;

    @GetMapping("/code/{id}")
    public ResponseEntity<String> getHtmlCodeById(@PathVariable int id) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Content-Type", "text/html");

        return ResponseEntity.ok().headers(responseHeaders).body(
                "<html>" +
                "<head>" +
                "   <title>Code</title>" +
                "   <style>" +
                "       span {" +
                "           color: green;" +
                "       }" +
                "       pre {" +
                "           width: 600px;" +
                "           background-color: lightgray;" +
                "           padding: 10px 10px 10px 10px;" +
                "           border: solid gray;" +
                "       }" +
                "   </style>" +
                "</head>" +
                "<body>" +
                "   <span id=\"load_date\">" + codeService.getDate(id) + "</span>" +
                "<pre id=\"code_snippet\">" + codeService.getCode(id) + "</pre>" +
                "</body>" +
                "</html>"
        );
    }

    @GetMapping("/api/code/{id}")
    @ResponseBody
    public Code getJsonCodeById(@PathVariable int id) {
        return codeService.getCodeById(id);
    }

    @PostMapping("/api/code/new")
    @ResponseBody
    public Id addJsonCode(@RequestBody Code newCode) {
        return codeService.addCode(newCode);
    }

    @GetMapping("/code/new")
    public ResponseEntity<String> addHtmlCode() {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Content-Type", "text/html");

        return ResponseEntity.ok().headers(responseHeaders).body(
                "<html>" +
                "<head>" +
                "   <title>Create</title>" +
                "   <script>" +
                "   function send() {\n" +
                "    let object = {\n" +
                "        \"code\": document.getElementById(\"code_snippet\").value\n" +
                "    };\n" +
                "    \n" +
                "    let json = JSON.stringify(object);\n" +
                "    \n" +
                "    let xhr = new XMLHttpRequest();\n" +
                "    xhr.open(\"POST\", '/api/code/new', false)\n" +
                "    xhr.setRequestHeader('Content-type', 'application/json; charset=utf-8');\n" +
                "    xhr.send(json);\n" +
                "    \n" +
                "    if (xhr.status == 200) {\n" +
                "      alert(\"Success!\");\n" +
                "    }\n" +
                "   }" +
                "   </script>" +
                "   <style>" +
                "       textarea {" +
                "           width: 500px;" +
                "           padding: 10px 10px 60px 10px;" +
                "       }" +
                "   </style>" +
                "</head>" +
                "<body>" +
                "   <form action=\"\">" +
                "<textarea id=\"code_snippet\">" + "// write your code here" + "</textarea>" +
                "<button id=\"send_snippet\" type=\"submit\" onclick=\"send()\">Submit</button>" + "</form>" +
                "</body>" +
                "</html>"
        );
    }

    @GetMapping("/api/code/latest")
    @ResponseBody
    public List<Code> getJsonCodeLatest() {
        return codeService.getLatest();
    }

    @GetMapping("/code/latest")
    public String getHtmlCodeLatest(Model model) {
        model.addAttribute("codes", codeService.getLatest());
        return "code";
    }
}
