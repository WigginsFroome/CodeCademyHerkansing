/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class UrlTest {
    
     /**
     * @desc Validates if url is valid. It should be in the form of:
     *       <https:// or http://><at least 1 character>.<at least 1 character>.<at least 1 character>
     * 
     * @subcontract no http or https part {
     *   @requires !url.contains("https://" || "http://") ||
     *             url.split("\\//")[1].length < 1;
     *   @ensures \result = false;
     * }
     * */
    
    
    @Test
    public void noUrlBeginTest(){
        //arrange
        String url = ".test.com";
        //act
        boolean result = Url.validateURL(url);
        //assert
        assertEquals(false, result);
    }
    
  
    
    /**
     * @subcontract no character after https or http {
     *   @requires !url.contains("https://" || "http://") ||
     *             url.split("\\//")[1].length < 1;
     *   @ensures \result = false;
     * }
     * */
    @Test
    public void noCharacterAfterBeginTest(){
        //arrange
        String url = "https://.t.c";
        //act
        boolean result = Url.validateURL(url);
        //assert
        assertEquals(false, result);
    }
    /**
     * @subcontract no end part {
     *   @requires !url.contains("https://" || "http://") ||
     *             url.split("\\//")[1].split("\\.")[2].split("\\.")[3] < 1;
     *   @ensures \result = false;
     * }
     * */
    @Test
    public void noEndPartTest(){
        //arrange
        String url = "https://w.t.";
        //act
        boolean result = Url.validateURL(url);
        //assert
        assertEquals(false, result);
    }
    /**
     * @subcontract no domain part {
     *   @requires !url.contains("https://" || "http://") ||
     *             url.split("\\//")[1].length < 1;
     *   @ensures \result = false;
     * }
     * */
    @Test
    public void noDomainPartTest(){
        //arrange
        String url = "https://w..c";
        //act
        boolean result = Url.validateURL(url);
        //assert
        assertEquals(false, result);
    }
    
    
    
    /**
     * @subcontract valid url {
     *   @requires no other precondition
     *   @ensures \result = true;
     * }
     * 
     */
    @Test
    public void validURLPartTest(){
        //arrange
        String url = "https://www.test.com";
        //act
        boolean result = Url.validateURL(url);
        //assert
        assertEquals(true, result);
    }
    
}