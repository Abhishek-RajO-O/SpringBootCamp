package com.abhishek.journalApp.Controller;

import com.abhishek.journalApp.Entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping (path = "/_journal")
public class JournalEntryController {

    private Map<Long , JournalEntry>  journalEntries= new HashMap();

    @GetMapping
    public List<JournalEntry> getAll(){ //localhost:8080/journal GET
        return new ArrayList<>(journalEntries.values());
    }

    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry myEntry){ //localhost:8080/journal POST
        journalEntries.put(myEntry.getId(), myEntry);
        return true;
    }

    @GetMapping(path = "/id/{myid}")
    public JournalEntry GetJournalEntryById(@PathVariable Long myid){
        return journalEntries.get(myid);
    }

    @DeleteMapping(path = "/id/{myid}")
    public JournalEntry deleteJournalEntryById(@PathVariable Long myid){
        return  journalEntries.remove((myid));
    }

    @PutMapping(path = "/id/{myid}")
    public JournalEntry deleteJournalUpdateById(@PathVariable Long myid ,@RequestBody JournalEntry myEntry){
        return  journalEntries.put(myid,myEntry);
    }

}
