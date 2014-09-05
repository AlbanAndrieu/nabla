# ansible-dns

A role for installing dns.


## Actions

- Ensures that dns is installed (using `apt`)


## Usage:
```
  # This playbook can be run using vagrant (on virtual box). 
  - name: Install dns
    hosts: dns
    user: root
  #  connection: local
    
    roles:
      - dns      
```

## License

MIT
