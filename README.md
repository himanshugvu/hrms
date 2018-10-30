Sub Test()

    Dim IE As Object
    Dim doc As HTMLDocument
    
    Set IE = CreateObject("InternetExplorer.Application")
     
    IE.Visible = True
    IE.navigate "https://www.facebook.com/"
    
    Do While IE.Busy
        Application.Wait DateAdd("s", 1, Now)
    Loop
    
    Set doc = IE.document
    
    doc.getElementById("u_0_n").Value = ThisWorkbook.Sheets("Data").Range("A2").Value
    
    doc.getElementById("u_0_l").Value = ThisWorkbook.Sheets("Data").Range("B2").Value
    doc.getElementById("u_0_11").Click
    
    doc.getElementById("email").Value = ThisWorkbook.Sheets("Data").Range("A2").Value
    
    doc.getElementById("pass").Value = ThisWorkbook.Sheets("Data").Range("B2").Value
    
    
        

End Sub
