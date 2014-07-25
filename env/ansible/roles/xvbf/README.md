# ansible-xvbf

A role for installing xvbf.


## Actions

- Ensures that xvbf is installed (using `apt`)


## Usage:
```
  # This playbook can be run using vagrant (on virtual box). 
  - name: Install xvbf
    hosts: xvbf
    user: root
  #  connection: local
    
    roles:
      - xvbf
```

## License

MIT
