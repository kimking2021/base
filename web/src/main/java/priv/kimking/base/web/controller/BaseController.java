package priv.kimking.base.web.controller;

import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.HandlerMapping;
import priv.kimking.base.web.aop.annotation.ExcelResp;
import priv.kimking.base.web.entity.Foo;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *
 * @author kim
 * @date 2021/1/11
 */
@RestController
@RequestMapping("/api/base")
public class BaseController {

    @GetMapping("/path/{bucket}/**/{filename}")
    public String getPath(@PathVariable String bucket, @PathVariable String filename, HttpServletRequest request) {

        final String path =
                request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE).toString();
        final String bestMatchingPattern =
                request.getAttribute(HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE).toString();
        String filePath = new AntPathMatcher().extractPathWithinPattern(bestMatchingPattern, path);
        String directory = filePath.substring(0, filePath.length()-filename.length()-1);

        System.out.println(bucket);
        System.out.println(filePath);
        System.out.println(directory);
        System.out.println(filename);
        return "hello";
    }

    @GetMapping("/foo")
//    @ExcelResp
    public Foo foo(@RequestBody Foo foo) {
        System.out.println(foo);
        Foo foo1 = new Foo();
        foo1.setFooFoo("foofoo");
        foo1.setFooBar("foo_bar");
        return foo1;
    }

    @GetMapping("/path")
    public String getRequestParameter(@RequestParam String param) {
        System.out.println(param);
        return "world";
    }

}
