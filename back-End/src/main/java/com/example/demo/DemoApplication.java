
package com.example.demo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
              import org.springframework.web.bind.annotation.RestController;
              
              class Occurances{
            	  private String word;
            	  private int count;
            	  
				public Occurances(String word, int count) {
					super();
					this.word = word;
					this.count = count;
					
				}

				public String getWord() {
					return word;
				}

				public void setWord(String word) {
					this.word = word;
				}

				public int getCount() {
					return count;
				}

				public void setCount(int count) {
					this.count = count;
				}
            	  
              }
              @CrossOrigin(origins ="http://localhost:50353/")
              @SpringBootApplication
              @RestController
              public class DemoApplication {
                
                  
                  public static void main(String[] args) {
                  SpringApplication.run(DemoApplication.class, args);
                  }
                  
                  @CrossOrigin(origins ="http://localhost:4200/")
                  @GetMapping("/wordcount")
                  public Map<String, Integer> wordCount(@RequestParam String input) {
                      // split the input string into words
                      String[] words = input.split(" ");

                      // create a map to store the word count
                      Map<String, Integer> wordCount = new HashMap<>();

                      // iterate over the words and count the occurrences
                      for (String word : words) {
                          if (wordCount.containsKey(word)) {
                              wordCount.put(word, wordCount.get(word) + 1);
                          } else {
                              wordCount.put(word, 1);
                          }
                      }

                      return wordCount;
                  }
                
              }
            
