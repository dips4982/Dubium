/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


window.onload = function() 
        {
            if(!window.location.hash)
            {
            window.location = window.location + '#';
            window.location.reload();
            }
        }