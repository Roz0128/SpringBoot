package me.with.study.controller;

import me.with.study.dto.MemberDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController // RestFul 한 컨트롤러 생성
@RequestMapping("/api/v1/get-api") // 공통된 URL을 넣어주기 위해 사용
public class GetController {

    // http://localhost:8080/api/v1/get-api/hello
    @RequestMapping(value = "/hello", method= RequestMethod.GET)
    public String getHello() {
        return "Hello World";
    }

    // http://localhost:8080/api/v1/get-api/name
    @GetMapping("/name") // GetMapping을 사용하게 되면 메소드 선언을 따로 해줄 필요 X
    public String getName(){
        return "ROZE";
    }

    // http://localhost:8080/api/v1/get-api/variable1/{String 값}
    @GetMapping("/variable1/{variable}") // "{variable}"와 일치 되는 @PathVariable을 따라 값이 들어오게 됨
    public String getVariable1 (@PathVariable String variable){
        return variable;
    }

    // http://localhost:8080/api/v1/get-api/variable2/{String 값}
    @GetMapping(value = "/variable2/{variable}") // String의 객체의 이름이 "{variable}"와 일치 하지 않음. -> 매개변수를 일치 시킬 수 없는 상황일 때 사용
    public String getVariable2(@PathVariable("variable") String var){
        return var;
    }

    // http://localhost:8080/api/v1/get-api/request1? -> ?을 기준으로 아래 3개의 key값을 받으면서 "="기준으로 value 값을 받는다
    // name=Roze&
    // email=rexlam@naver.com&
    // organization=Study
    @GetMapping("/request1")
    public String getRequestParam1(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String organization){
        return name + " " + email + " " + organization;
    }

    // http://localhost:8080/api/v1/get-api/request2?key1=value&key2=value2
    @GetMapping("/request2")
    public String getRequestParam2(@RequestParam Map<String, String> param){ // key와 value 값이 어떤 값이 들어올지 모르는 경우
        StringBuilder sb = new StringBuilder();
        param.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });

//        param.forEach(key, value) -> sb.append(key).append(" : ").append(value).append("\n");

        return sb.toString();
    }

    // http://localhost:8080/api/v1/get-api/request3?name=Roze&email=rexlam@naver.com&organization=Study
    @GetMapping("/request3")
    public String getRequestParam3(MemberDto memberDto){

        // return memberDto.getName() + " " + memberDto.getEmail() + " " + memberDto.getOrganization();
        return memberDto.toString();
    }
}
