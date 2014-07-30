# ansible-swarm

A role for installing selenium.


## Actions

- Ensures that selenium is installed (using `apt`)


## Usage:
```
  - name: Install selenium
    hosts: selenium
    user: root
  #  connection: local
  
    roles:
      - selenium
```

## License

MIT
