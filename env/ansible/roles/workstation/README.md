# ansible-workstation

A role for installing workstation.


## Actions

- Ensures that workstation is installed (using `apt`)


## Usage:
```
  - name: Install workstation
    hosts: workstation
    user: root
  #  connection: local
    
    roles:
      - workstation      
```

## License

MIT
